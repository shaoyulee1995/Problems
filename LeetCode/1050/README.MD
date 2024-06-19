# Actors and Directors Who Cooperated At Least Three Times

```sql
select actor_id, director_id
from ActorDirector
group by actor_id, director_id
having count(timestamp) >= 3;
```
