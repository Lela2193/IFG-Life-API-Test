import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

println('Starting IFG LIFE Test Case: TC04_DeleteUser')

// Kirim DELETE request
def response = WS.sendRequest(findTestObject('IFG LIFE/Delete User'))

// Ambil status & body
def status = response.getStatusCode()

def body = response.getResponseBodyContent()

println("Response status code: $status")

println('Response body: ')

// Verifikasi status code = 204
WS.verifyResponseStatusCode(response, 204)

// Pastikan body kosong
assert (body == null) || body.trim().isEmpty()

// Log hasil sukses
println("[IFG LIFE] DeleteUser test passed successfully with status $status")

