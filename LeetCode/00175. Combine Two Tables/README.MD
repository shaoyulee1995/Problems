```
select
    firstName,
    lastName,
    city,
    state
from
    Person left join Address
    using(personId)

```