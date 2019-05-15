#import sysI
import re

def dist_sq(x1,y1,x2,y2):
    '''
    return the square of the distance between the two points (x1,y1) and (x2,y2)
    '''
    return (x2-x1)**2 + (y2-y1)**2
# end def dist_sq

def perp(x1,y1,x2,y2,x3,y3,x4,y4):
    '''
    return if two line segments are perpendicular to each other
    '''

    run1 = x2 - x1
    rise1 = y2 - y1

    run2 = x4 - x3
    rise2 = y4 - y3

    if (run1 == 0 and rise2 == 0):
        # line 1 is vertical and line 2 is horizontal
        return True
    elif (run2 == 0 and rise1 == 0):
        # line 2 is vertical and line 1 is horizontal
        return True
    elif (rise1*rise2 == -(run1*run2)):
        # check if slopes are negative reciprical
        return True
    else:
        return False
    # end if
# end def perp

try:
    while True:
        verts = []
        for vert in range(int(input())):
            verts.append(input())

        xcoords = []
        ycoords = []
        coordinates = []

        for v in (verts):
            coords = v.split()

            xcoords.append(int(coords[0]))
            ycoords.append(int(coords[1]))
        
        num_verts = len(xcoords)
        
        if (num_verts % 2 == 1):
            # odd number of verts, answer is 0
            print ('0')
        else:
            half = int(num_verts / 2)
            count = 0
            for c in range(half): # only need to loop over first half, as second half will already have been done
                sx1 = xcoords[c]
                sx2 = xcoords[c+half]

                sy1 = ycoords[c]
                sy2 = ycoords[c+half]

                bisect = True

                for d in range(1,half):
                    bx1 = xcoords[c+d]
                    bx2 = xcoords[c-d]

                    by1 = ycoords[c+d]
                    by2 = ycoords[c-d]

                    if ((dist_sq(sx1,sy1,bx1,by1) == dist_sq(sx1,sy1,bx2,by2)) and perp(sx1,sy1,sx2,sy2,bx1,by1,bx2,by2)):
                        # bisects
                        pass
                    else:
                        # does not bisect, breakout of loop
                        bisect = False
                        break
                # end for d

                if (bisect):
                    count += 1
            # end for c

            print (count)
        # end if (num_verts % 2 == 1):

    # end while True:

except:
    #quietly exit
    pass