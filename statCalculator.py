STARTING_HP = 250
STARTING_ATTACK = 100
STARTING_DEFENSE = 50

ALL_TESTS = [1, 2, 3, 4, 5, 10, 15, 25, 50, 75, 100]

def stat_multiplier(starting_value, multiplier, level_list):
    result_list = []
    for num in level_list:
        growth = num * (num + 1) // 2
        new_stat = starting_value + multiplier * growth
        result_list.append(new_stat)
    return result_list

def print_results(levels, hp_results, attack_results, defense_results):
    print("Level\tHP\t\tAttack\t\tDefense")
    print("------------------------------------------------------")
    for i in range(len(levels)):
        print(f"{levels[i]}\t{hp_results[i]:,.0f}\t\t{attack_results[i]:,.0f}\t\t{defense_results[i]:,.0f}")

def main():
    HP_results = stat_multiplier(STARTING_HP, 5, ALL_TESTS)
    attack_results = stat_multiplier(STARTING_ATTACK, 3, ALL_TESTS)
    defense_results = stat_multiplier(STARTING_DEFENSE, 2, ALL_TESTS)

    print_results(ALL_TESTS, HP_results, attack_results, defense_results)

main()
