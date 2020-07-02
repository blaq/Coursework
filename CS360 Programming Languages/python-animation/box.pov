#include "textures.inc"
#include "textures.inc"


camera {
     perspective
     location <5,4,-2.5>
     look_at <.5,0,.5>
}



light_source {
    <15,15,-20>,
    color rgb <0.75,0.75,0.65>
}


plane {
    <0,1,0>, -1
    pigment { rgb <1,1,1> }
}



difference  {
    box {
        <-1,-1,-1>,<2,2,2>
        texture{  Gold_Nugget  }
    }


    sphere {
        <.5,.5,.5>
        2
        texture { Apocalypse }
    }
}


sphere {
    <.5,.5,.5>
    1.5
    texture { Starfield }
}
