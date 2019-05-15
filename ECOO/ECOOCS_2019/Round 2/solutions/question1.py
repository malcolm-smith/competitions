#import sysI
import re

addresses = []
lower_addresses = []

try:
    while True:
        for address in (range(int(input()))):
            addresses.append(input())

        for a in addresses:
            # lower case the addresses
            lower_addresses.append(a.lower())

        final_addresses = []

        for a in range(len(lower_addresses)):
            # split the address into the user part (before the @ sign) and everything else (including the @ sign)
            email = re.match('(.*)(@.*)',lower_addresses[a])
            (user, at) = email.groups()

            user = re.sub(r'\.','',user)   # delete all the '.'
            user = re.sub(r'\+.*','',user)   # delete all the chars from + to the end
            final_addresses.append(user + at)       # concat the parts back together and store

        final = []
        for a in (final_addresses):
            if (not a in (final)):
                final.append(a)             # add in only the unique ones

        print(len(final))

        # reset for new list
        addresses = []
        lower_addresses = []

except:
    #quietly exit
    pass