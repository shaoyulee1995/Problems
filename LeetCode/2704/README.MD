# To Be Or Not To Be

```ts
type ToBeOrNotToBe = {
    toBe: (val: any) => boolean;
    notToBe: (val: any) => boolean;
};

function expect(val: any): ToBeOrNotToBe {
    return {
        toBe: (val2) => toBe(val, val2),
        notToBe: (val2) => notToBe(val, val2)
    } 
};

function toBe(val1, val2){
    if(val1 !== val2){
        throw new Error("Not Equal");
    }
    return true;
}

function notToBe(val1, val2){
    if(val1 === val2){
        throw new Error("Equal");
    }
    return true;
}
```