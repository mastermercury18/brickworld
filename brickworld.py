import json
import random 
import player_vs_npc2

inventory = {}
gallery = {}

def load_gallery():
    global gallery
    gallery = get_dictionary_from_json_file("/Users/neha/Documents/python/brick_gallery.json")
   
def load_inventory():
    global inventory
    inventory = get_dictionary_from_json_file("/Users/neha/Documents/python/brick_inventory.json")
  
def get_dictionary_from_json_file(file_name):
    with open(file_name) as f:
        creation_dict = json.load(f)
    return creation_dict

def get_brick_quantity(brick):
    quantity = 0
    if brick in inventory:
        quantity = inventory[brick]
    return int(quantity) 

def reduce_brick_quantity(brick, qty):
    available_quantity = get_brick_quantity(brick)
    if qty < available_quantity:
        available_quantity = available_quantity - qty
        inventory[brick] = available_quantity
        return True
    else:
        print("Oops! That's too much! Try again!")
        return False

def update_inventory(bricks, new_part_quantity):
    inventory[bricks] = new_part_quantity + inventory[bricks]

def display_inventory():
    print("\nHere is the brick_inventory:")
    for key in inventory:
        print(key, ":", inventory[key])
    

def display_creation(bricks, name_of_creation):
    print("\n", name_of_creation, "so far has the following ingredients...")
    for key in bricks:
        print(key, ":", bricks[key])
    
def creation():
    print(
    """
    Welcome to creating a building! 

    Press 1 - To actually build! 
    Press 2 - To edit a creation
    Press 3 - To rename a creation
    Press 4 - To exit
    """
    )
    choice = int(input("Enter your choice: "))
    if choice == 1:
        print("Time to get started!")
        name_of_creation = input("Enter the creation's name: ")
        bricks = {}
        brick = ""
        while brick != "None":
            display_inventory()
            brick = input("What brick would you like to use? (None to exit): ")
            if brick not in inventory and brick != "None":
                print("Oops! That's not a brick!")
            else:
                if brick != "None":
                    brick_quantity = int(input("How much would you like to use?"))
                    if reduce_brick_quantity(brick, brick_quantity):
                        bricks[brick] = brick_quantity
                        display_creation(bricks, name_of_creation)
        display_creation(bricks, name_of_creation)
        
        print("Saving your progress.")
        gallery[name_of_creation] = bricks
        save_gallery()
        save_inventory()
    elif choice == 2:
        display_gallery()
        creation_to_edit = input("\nWhich creation would you like to edit: ")
        bricks = gallery[creation_to_edit]
        display_creation(bricks, creation_to_edit)
        display_inventory()
        edit_option= input("\nPress A to add or press R to reduce: ")
        if edit_option == "A":
            new_brick = input("\nWhat brick would you like to add?: ")
            new_brick_quantity = int(input("How much do you want?: "))
            if reduce_brick_quantity(new_brick, new_brick_quantity):
                if new_brick not in bricks:
                    bricks[new_brick] = new_brick_quantity
                else:
                    bricks[new_brick] = bricks[new_brick] + new_brick_quantity
        else:
            new_brick = input("\nWhat brick would you like to reduce?: ")
            if new_brick in bricks:
                new_brick_quantity = int(input("How much do you want to reduce?: "))
                if new_brick_quantity > bricks[new_brick]:
                    print("Sorry, that's too much. Try again.")
                elif new_brick_quantity == bricks[new_brick]:
                    del bricks[new_brick]
                else:
                    bricks[new_brick] = bricks[new_brick] - new_brick_quantity
                update_inventory(new_brick, new_brick_quantity)
            else:
                print("Sorry. That brick does not exist in the creation.")

        display_creation(bricks, creation_to_edit)
        display_inventory()
        save_gallery()
        save_inventory()

    elif choice == 3:
        display_gallery()
        creation_to_rename = input("What creation would you like to rename?: ")
        new_name = input("What would you like to name it?: ")
        gallery[new_name] = gallery.pop(creation_to_rename)
        display_gallery()
        save_gallery()

    else:
        print("\n\nPress the enter key to exit.")

def save_dict_to_file(file_name, creation_dict):
    print("Saving dictionary to file.", file_name)
    json1 = json.dumps(creation_dict)
    text_file = open(file_name, "w")
    text_file.write(json1)
    text_file.close()

def save_gallery():
    save_dict_to_file("/Users/neha/Documents/python/brick_gallery.json", gallery)

def save_inventory():
    save_dict_to_file("/Users/neha/Documents/python/brick_inventory.json", inventory)

def display_gallery():
    print("\nHere is your gallery: \n")
    for key in gallery:
        print(key, ":", gallery[key])

def main():
    load_inventory()
    display_inventory()
    load_gallery()
    display_gallery()
    exit_prog = "no"
    while exit_prog != "yes":
        creation()
        exit_prog = input("\nWould you like to exit? Press yes or no: ").lower()

#main()


def testing_something(creation):
    number = random.randint(0,1000)
    if "2x2" in gallery[creation] and number%3:
        print("\nGunner Mayhem spawns.")
        player_vs_npc2.start_game()
    else: 
        print("Nothing.")
#testing_something("wally")

main()