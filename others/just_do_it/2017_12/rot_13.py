# worked only in python 2
from string import  ascii_lowercase, ascii_uppercase, maketrans

a = 'Hello world'

print a.encode('rot_13')                          # Uryyb jbeyq


rot13_lowercase = ascii_lowercase[13: ] + ascii_lowercase[: 13]
rot13_uppercase = ascii_uppercase[13: ] + ascii_uppercase[: 13]
rot13_table = maketrans(ascii_lowercase + ascii_uppercase, rot13_lowercase + rot13_uppercase)

print 'Hello world'.translate(rot13_table)        # Uryyb jbeyq
