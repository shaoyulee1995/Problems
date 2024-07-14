# Replace Employee ID With The Unique Identifier

```sql
select
    unique_id,
    name
from
    Employees left join EmployeeUNI
    using(id)
```
