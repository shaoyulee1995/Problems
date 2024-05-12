# The Winner University
```
select 
    case
        when sum(n.score >= 90) > sum(c.score>= 90) then 'New York University'
        when sum(n.score >= 90) < sum(c.score>= 90) then 'California University'
        else 'No Winner'
    end as 'winner'
from 
    NewYork n, 
    California c
```