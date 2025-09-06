# Bitwise User Permissions Analysis

```sql
select
    bit_and(permissions) as 'common_perms',
    bit_or(permissions) as 'any_perms'
from
    user_permissions
```