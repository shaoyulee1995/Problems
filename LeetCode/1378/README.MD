# Replace Employee ID With The Unique Identifier

```
select
    unique_id,
    name
from
    Employees left join EmployeeUNI
    using(id)
```
