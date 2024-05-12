# Project Employees I
```
select
    project_id,
    round(avg(experience_years), 2) as 'average_years'
from
    Project left join Employee
    using(employee_id)
group by
    1
```