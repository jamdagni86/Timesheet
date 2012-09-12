using TimesheetService.DataContracts;

namespace TimesheetService {
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Timesheet" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Timesheet.svc or Timesheet.svc.cs at the Solution Explorer and start debugging.
    public class Timesheet : ITimesheet {

        public Result Login(Login loginInfo) {

            return new Result {
                Success = true,
                Data = "-1390078505S-1-5-21-873596329-1595174118-21871"
            };
        }

        public WorkItem[] GetTasks(string uid) {
            return new[] { 
                new WorkItem { ID = 1, Item = "Coding" }, 
                new WorkItem { ID = 2, Item = "Code Review" }, 
                new WorkItem { ID = 3, Item = "Bug Fixing" }, 
                new WorkItem { ID = 2, Item = "Unit Testing" } 
            };
        }
    }
}
