using TimesheetService.DataContracts;

namespace TimesheetService {
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Timesheet" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Timesheet.svc or Timesheet.svc.cs at the Solution Explorer and start debugging.
    public class Timesheet : ITimesheet {

        public Result Login(Login loginInfo) {            

            return new Result {
                Success = true,
                Data = "S-1-5-21-873596329-1595174118-1390078505-21871"
            };
        }
    }
}
