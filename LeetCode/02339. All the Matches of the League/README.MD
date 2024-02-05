```
select
    home.team_name as 'home_team',
    opponent.team_name as 'away_team'
from
    Teams home cross join Teams opponent
where
    home.team_name != opponent.team_name 
```