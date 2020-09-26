### This project demonstrates how Spring transactions work.

The project exposes a REST service to showcase @Transactional behavior. Use the following endpoints to simulate different behaviors,

**POST /demo/noRollback** - successful execution, no rollback  
**POST /demo/rollbackOnRuntimeException** - rollback on RuntimeException  
**POST /demo/noRollbackOnCheckedException** - no rollback on checked exception  
 