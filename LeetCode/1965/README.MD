# Employees With Missing Information

```sql
select
    employee_id
from Employees
where employee_id not in (
    select
        employee_id
    from Salaries)
union
select
    employee_id
from Salaries
where employee_id not in (
    select employee_Id
    from Employees)
order by employee_id
```
