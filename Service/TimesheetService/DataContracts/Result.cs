using System.Runtime.Serialization;

namespace TimesheetService.DataContracts {
    [DataContract]
    public class Result {
        [DataMember(Name="success")]
        public bool Success { get; set; }

        [DataMember(Name="data")]
        public object Data { get; set; }

        [DataMember(Name="errorMessage")]
        public string ErrorMessage { get; set; }
    }
}