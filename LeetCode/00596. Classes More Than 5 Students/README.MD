# Group By, Having 
```
select class
from Courses
group by class
having count(distinct student) >= 5
```
# Sub query
```
select class
from (select class, count(distinct(student)) as num
    from Courses
    group by class) as t
where num >= 5;
```