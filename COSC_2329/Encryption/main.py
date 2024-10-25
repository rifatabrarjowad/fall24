# alf = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
# alf2 = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
# space = " "
# common_ver = 0
# print(space,  end=" ")
# for i in range(len(alf2)):
#     print(alf2[i], end=" ");

# print()
# for j in range(len(alf)):
#     common_ver = j
#     print(alf[j], end=" ")
#     for i in range(len(alf2)):
#         print(alf2[common_ver], end=" ");
#         common_ver = common_ver+1
        
    
#     print()


alf = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
alf2 = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
space = " "

# Print the first row with uppercase letters
print(space, end=" ")
for i in range(len(alf2)):
    print(alf2[i], end=" ")
print()

# Print each lowercase letter and its corresponding uppercase shifted version
for j in range(len(alf)):
    common_ver = j
    print(alf[j], end=" ")  # Print the lowercase letter
    for i in range(len(alf2)):
        print(alf2[common_ver % len(alf2)], end=" ")  # Use modulo to loop back to the start of alf2
        common_ver = common_ver + 1
    print()
