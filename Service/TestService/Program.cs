using System.IO;
using System.Net;

namespace TestService {
    class Program {
        static void Main(string[] args) {
            WebClient client = new WebClient();
            try {
                client.Headers.Add("content-type", "application/json");
                string response = client.UploadString("http://localhost/Json/Service1.svc/GetDataUsingDataContract", "{\"composite\" : { \"BoolValue\" : true, \"StringValue\" : \"String\"},\"testInt\" : 1}");
                
            } catch (WebException ex) {

                string exceptionDetails = new StreamReader(ex.Response.GetResponseStream()).ReadToEnd();
            }
        }
    }
}
