procedure mergesort( array,N )
array – list of elements to be sorted
N – number of elements in the list
begin
if ( N == 1 ) return array
var array1 as array = a[0] ... a[N/2]
var array2 as array = a[N/2+1] ... a[N]
array1 = mergesort(array1)
array2 = mergesort(array2)
return merge( array1, array2 )
end procedure
procedure merge(array1, array2 )
    array1 – first array
    array2 – second array
begin
var c as array
while ( a and b have elements )
if ( array1[0] > array2[0] )
             add array2 [0] to the end of c
             remove array2 [0] from array2
else
             add array1 [0] to the end of c
             remove array1 [0] from array1
end if
end while
while ( a has elements )
add a[0] to the end of c
remove a[0] from a
end while
    
while ( b has elements )
add b[0] to the end of c
remove b[0] from b
end while
    
return c
end procedure
