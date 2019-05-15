import re

verts = []
try:
    while True:
        # read in N (length of ribbon) and M (number of folds)
        line = input()
        length = int(line.split()[0])
        folds = int(line.split()[1])

        # need an array 3 times as long, ribbon is in the "middle" length, so thickness here is 1, 0 elsewhere

        ribbon = []

        for r in range(length):
            ribbon.append(0)
        for r in range(length):
            ribbon.append(1)
        for r in range(length):
            ribbon.append(0)
        
        for f in range(folds):
            line = input()

            fold_pos = int(line.split()[0])
            direction = line.split()[1]

            if (direction == 'L'):
                # we are folding left, so start at position length + fold_pos

                folding_position = length + fold_pos - 1

                for offset in range(length):
                    from_pos = folding_position-offset-1
                    to_pos = folding_position + offset

                    ribbon[to_pos] += ribbon[from_pos]
                    ribbon[from_pos] = 0
                # end for offset
            else:
                # we are folding right, so start at position length + fold_pos
                # but now the fold from and to positions are reversed (and slight offset adjustment)

                folding_position = length + fold_pos - 1

                for offset in range(length):
                    from_pos = folding_position+offset+1
                    to_pos = folding_position - offset

                    ribbon[to_pos] += ribbon[from_pos]
                    ribbon[from_pos] = 0
                # end for offset
            # end if direction
        # end folds

        final_length = 0
        final_thickness = 0

        for r in range(len(ribbon)):
            # count the number of non-zero entries, this is the length of the ribbon
            # figure out the max value of the ribbon, this is the thickness
            if (ribbon[r] > 0):
                # actual ribbon
                final_length += 1
                final_thickness = max(final_thickness,ribbon[r])

        print (final_length, final_thickness)
    # end while True:

except:
    #quietly exit
    pass