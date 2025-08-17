# Project Employees II

```sql
with max_employee as (
    select
        project_id,
        count(employee_id) as 'employee_count'
    from
        Project
    group by
        1
)

select
    project_id
from 
    max_employee
where
    employee_count = (select max(employee_count) from max_employee)
```