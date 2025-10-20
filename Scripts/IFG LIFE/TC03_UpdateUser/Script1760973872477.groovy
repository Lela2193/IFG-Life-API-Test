import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper

println('Starting IFG LIFE Test Case: TC03_UpdateUser')

// Request PUT ke API
def response = WS.sendRequest(findTestObject('IFG LIFE/Update user'))

// Ambil status & body
def status = response.getStatusCode()

def body = response.getResponseBodyContent()

println("Response status code: $status")

println('Response body: ' + body)

// Verifikasi status code = 200
WS.verifyResponseStatusCode(response, 200)

// Parse JSON respons
def jsonResponse = new JsonSlurper().parseText(body)

// Verifikasi bahwa respons mengandung field yang diharapkan
assert jsonResponse.containsKey('updatedAt') : 'Response doesn\'t contain \'updatedAt\' field'

// Log hasil & value aktual
println("Actual name returned: $jsonResponse.name")

println("Actual job returned: $jsonResponse.job")

// Verifikasi minimal struktur benar (bukan nilai fix)
assert (jsonResponse.name != null) && (jsonResponse.job != null) : 'Response missing name/job'

// Hasil akhir
println("[IFG LIFE] UpdateUser test passed successfully with status $status")

