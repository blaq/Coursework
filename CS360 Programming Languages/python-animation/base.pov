#include "colors.inc"

camera{ location < -6, 4, 1 > look_at < 0, 2, 5 > }     

sphere{ < 0, 1, 9 >, 2 texture { pigment { color Orange } } }  
         
difference{ cylinder{ < 0, .999, 9 >, < 0, 1.001, 9 >, 5 pigment{ color Red } }				cylinder{ < 0, .5, 9 >, < 0, 1.5, 9 >, 3.5 } }   
            
light_source{ < 20, 10, -30 > color Yellow }