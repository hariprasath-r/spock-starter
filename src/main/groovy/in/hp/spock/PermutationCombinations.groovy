package in.hp.spock

def permutations = ['a1', 'a2'].permutations()
println permutations

def multiDimensionArray = [['b1', 'd1', 'c1'], ['b2', 'd2', 'c2']]
def combinations = multiDimensionArray.combinations()
println combinations

def complex = [permutations, multiDimensionArray].combinations()
println complex
