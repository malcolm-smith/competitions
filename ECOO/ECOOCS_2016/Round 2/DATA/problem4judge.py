"""This program can be used to score the output for the Calculator question. Move the ouptut and the data files to the same folder as this script, set dataset to 0, 1 or 2 and everything should work just fine :-). 

Note that if you score dataset 0 there are only 3 TCs, so cases 4 to 10 will probably come up as ERROR. 

Sam. """

DATASET = 1
debug = False

# calculator states
EMPTY = 0
ACCUMULATE = 1
PENDING = 2
ACCUMULATE2 = 3
WAIT = 4

class calc:
    def __init__(self):
        self.screen = "0"
        self.sbinary = "x"
        self.soperand = 0
        self.state = EMPTY
        self.mem = 0
        
    def clear(self):
        self.screen = "0"
        self.sbinary = "x"
        self.soperand = 0
        self.state = EMPTY
        
    def copyfrom(self, other, key):
        self.screen = other.screen
        self.soperand = other.soperand
        self.sbinary = other.sbinary
        self.state = other.state
        self.mem = other.mem

    def print(self):
        print(self.screen, self.mem, self.sbinary, self.soperand, self.state)
        
def replace(c, s):
    c.screen = s

def append(c, s):
    c.screen += s

def applyunary(c, op):
    if op == "n":
        c.screen = str(-int(c.screen))
    elif op == "s":
        c.screen = str(int(c.screen)**2)
    else:
        print("ERROR: applyunary")

def applybinary(c):
    if c.sbinary == "+":
        c.screen = str(c.soperand + int(c.screen))
    elif c.sbinary == "-":
        c.screen = str(c.soperand - int(c.screen))
    elif c.sbinary == "*":
        c.screen = str(c.soperand * int(c.screen))
    else:
        print("ERROR: applybinary")
  
def storescreen(c):
    c.soperand = int(c.screen)

def storeoperator(c, op):
    c.sbinary = op
    
def processdigit(c1, digit):
    c2 = calc()
    c2.copyfrom(c1, digit)
    if c2.state == EMPTY:
        replace(c2, digit)
        c2.state = ACCUMULATE
    elif c2.state == ACCUMULATE:
        append(c2, digit)
    elif c2.state == PENDING:
        replace(c2, digit)
        c2.state = ACCUMULATE2
    elif c2.state == WAIT:
        replace(c2, digit)
        c2.state = ACCUMULATE
    elif c2.state == ACCUMULATE2:
        append(c2, digit)
    else:
        print("ERROR: processdigit")
    return c2

def processunary(c1, op):
    c2 = calc()
    c2.copyfrom(c1, op)
    if c2.state == EMPTY or c2.state == ACCUMULATE or c2.state == WAIT or c2.state == PENDING:
        applyunary(c2, op)
        storescreen(c2)
        c2.state = WAIT
    elif c2.state == ACCUMULATE2:
        applyunary(c2,op)
        applybinary(c2)
        storescreen(c2)
        c2.state = WAIT
    else:
        print("ERROR: processunary")
    return c2

def processbinary(c1, op):
    c2 = calc()
    c2.copyfrom(c1, op)
    if c2.state == EMPTY or c2.state == WAIT:
        storescreen(c2)
        storeoperator(c2, op)
        c2.state = PENDING
    elif c2.state == ACCUMULATE:
        storescreen(c2)
        storeoperator(c2, op)
        c2.state = PENDING
    elif c2.state == PENDING:
        storeoperator(c2, op)
    elif c2.state == ACCUMULATE2:
        applybinary(c2)
        storescreen(c2)
        storeoperator(c2, op)
        c2.state = PENDING
    else:
        print("ERROR: processbinary")
    return c2

def processmemory(c1, op):
    c2 = calc()
    c2.copyfrom(c1, "m"+op)
    if op == "s":
        c2.mem = int(c.screen)
    elif op == "r":
        c2.screen = str(c2.mem)
        if c2.state == EMPTY or c2.state == WAIT:
            c2.state = ACCUMULATE
        elif c2.state == PENDING:
            c2.state = ACCUMULATE2
    else:
        print("ERROR: processmemory")
    return c2

def processkey(c, key):
    if key in "1234567890":
        return processdigit(c, key)
    if key in "+-*":
        return processbinary(c, key)
    if key in "ns":
        return processunary(c, key)

f = open("OUTPUT4"+str(DATASET)+".txt","r")
fdata = open("DATA4"+str(DATASET)+".txt","r")

score = 0
for tc in range(10):
    commands = f.readline().strip().split()
    keysallowed = fdata.readline().strip()
    target = fdata.readline().strip()
    if debug: print(keysallowed, target)
    #print(commands)
    c = calc()
    error = False
    if len(commands) == 0:
        if debug: print("error 4: empty command string")
        error = True
    for keypress in commands:
        if debug: print(">>> ",keypress)
        if len(keypress) == 2 and keypress[0] == "m":
            memkeypress = keypress[1]
            if memkeypress in "sr":
                c = processmemory(c, memkeypress)
            else:
                if debug: print("error 1:",keypress)
                error = True
                break
        elif len(keypress) == 1:
            if keypress in keysallowed:
                c = processkey(c, keypress)
            else:
                if debug: print("error 3:",keypress)
                error = True
                break
        elif keypress == "ac":
            c.clear()
        else:
            if debug: print("error 2:",keypress)
            error = True
            break
        # c.print()
    if error:
        print("Case",tc+1,"- ERROR")
    else:
        if c.screen == target:
            print("Case",tc+1,"- CORRECT")
            score += 10
        else:
            print("Case",tc+1,"- WRONG")
            # print(c.screen,target)
if score == 100 and DATASET == 1:
    print("+10 POINT BONUS")
    score += 10
print("\n\nFINAL SCORE: "+str(score))
f.close()
fdata.close()
           
