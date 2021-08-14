# text1 = 'a-b-c'
# text2 = 'a b c'
# text_split1 = text1.split('-')
# text_split2 = text2.split(' ')
# print(text_split1)
# print(text_split2)
#
text_ls = ['a', 'b', 'c']
text_tuple = ('a', 'b', 'c')
print(''.join(text_ls))
print('-'.join(text_tuple))
# print(text_tuple[0])
# print(text_tuple[1])
# print(text_tuple[2])

# a = [1,2,3]
# b = [2,3]
# print(a+b)
# print(a-b)

# from itertools import permutations
# print(list(permutations([1,2,3], 2)))
# print(list(permutations([3,1,3], 2)))
#
# from itertools import combinations_with_replacement
# print(list(combinations_with_replacement([1,2], 2)))
# print(list(combinations_with_replacement([3,1,3], 3)))
#
# from itertools import product
# print(list(combinations_with_replacement([1,2], 2)))
# print(list(product([1,2], repeat=2)))

# x = {'a': 4, 'b': 2, 'c': 3, 'd': 1, 'e': 0}
# print(dict(sorted(x.items(), key=lambda item: item[1])))
# print(dict(sorted(x.items(), key=lambda item: item[0])))
#
# for key in x:
#     print(key)
#
# for key in x.keys():
#     print(key)
#
# for value in x.values():
#     print(value)
#
# for key, value in x.items():
#     print(key, value)

# A ={'a', 'b', 'c', 'd'}
#
# print('Return Value is', A.pop())
# print('A = ', A)

# A = {'a', 'b', 'c', 'd'}
# B = {'c', 'f', 'g'}
#
# # Equivalent to A-B
# print(A-B)
# print(A.difference(B))
#
# # Equivalent to B-A
# print(B-A)
# print(B.difference(A))
#
# A = {2, 3, 5}
# B = {1, 3, 5}
# print(A+B)

a = (2,1)
b = (1,2)
print(a+b)
a.index(1)
# a.remove(1)
sorted(a)
print(a)
a.sort()

x = {'a': 4, 'b': 2, 'c': 3, 'd': 1, 'e': 0}
print(dict(sorted(x.items(), key = lambda x: x[1])))
print(dict(sorted(x.items(), key = lambda x: x[0])))