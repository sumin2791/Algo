A,B = input().split()
A = int(A)
B = int(B)

if A == 0:
    if B < 45:
        print("23 "+str(B+15))
    else:
        print("0 "+str(B-45))
else:
    if B < 45:
        print(str(A-1)+" "+str(B+15))
    else:
        print(str(A)+" "+str(B-45))