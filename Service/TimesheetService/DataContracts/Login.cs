using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace TimesheetService.DataContracts {
    
    [DataContract]
    public class Login {
        [DataMember(Name="userName")]
        public String UserName;

        [DataMember(Name = "password")]
        public String Password;
    }

}