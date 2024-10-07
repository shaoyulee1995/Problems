# The Number of Employees Which Report to Each Employee

```sql
select 
    manager.employee_id,
    manager.name,
    count(employee.reports_to) as 'reports_count',
    round(avg(employee.age)) as 'average_age'
from
    Employees employee join Employees manager
    on employee.reports_to = manager.employee_id
group by 
  1
order by 
  1
```