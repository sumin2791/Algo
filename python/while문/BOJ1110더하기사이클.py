A = int(input())
cnt = 0
num = A
while(True):
    if num < 10:
        num *= 11
        cnt += 1
    else:
        new = (int(num/10) + num%10)%10
        num = (num%10)*10 + new
        cnt+= 1
    if num == A:
        break

print(cnt)
