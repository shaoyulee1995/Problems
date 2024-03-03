```
select
    class
from 
    Courses
group by
    1
having 
    count(*) >= 5
```
```
select 
    class
from (
    select 
        class, 
        count(distinct(student)) as num
    from 
        Courses
    group by 
        class) as t
where num >= 5;
```