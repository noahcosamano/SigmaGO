STARTING_LEVEL = 1
MAX_LEVEL = 100
STARTING_XP = 0

ALL_TESTS = []

def create_all_tests():
    for num in range(2,101):
        ALL_TESTS.append(num)

def needed_xp_calculator(level_list):
    result_list = []
    for level in level_list:
        needed_xp = (level * level) * 100
        result_list.append(needed_xp)
    return result_list

def print_results(level_list, results):
    print("Level\tNeeded XP")
    print("------------------------------------------------------")
    for i in range(len(level_list)):
        print(f"{level_list[i]}\t{results[i]:,.0f}")

def main():
    create_all_tests()

    results = needed_xp_calculator(ALL_TESTS)

    print_results(ALL_TESTS, results)

main()
