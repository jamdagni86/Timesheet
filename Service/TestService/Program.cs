using System.IO;
using System.Net;

namespace TestService {
    class Program {
        static void Main(string[] args) {
            WebClient client = new WebClient();
            try {
                client.Headers.Add("content-type", "application/json");
                string response = client.UploadString("http://localhost/Json/Timesheet.svc/Login", "{\"loginInfo\" : { \"userName\" : \"\", \"password\" : \"\"} }");
                
            } catch (WebException ex) {

                string exceptionDetails = new StreamReader(ex.Response.GetResponseStream()).ReadToEnd();
            }
        }
    }
}
