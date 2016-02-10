# Visibility
Given the southwest and northeast coordinates x,y and the height of N buildings in a map,
finds how many of them are visable from an observator in the south side of the map.

In detail, the program reads an integer N, which is the number of the buildings in the map, and for the next N lines reads the 4 corner coordinates for each building: southwestX, southwestY, northeastX, northeastY and the height of each building.
For an observer in the south side of the map, the program outputs how many buildings he can see, regardless of point from
which he looks. This means,he can see a building which is further north than others but is higher or another which is closer to him.

Written in Java and OCaml 

for java program: 
compile: javac Visibility.java    
execute: java Visibility map.txt    
 or by using eclipse

for OCaml program: 
compile: ocamlc -o visable visable.ml 
execute: ./visable "map.txt"

example: 
map.txt

7  
1 1 3 3 6.0  
5 1 7 3 6.0  
9 1 11 3 6.0  
1 4 3 6 6.0  
5 4 7 6 6.0  
9 4 11 6 6.0  
1 7 11 8 3.25  

The output is 4.
