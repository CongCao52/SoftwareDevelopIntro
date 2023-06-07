#name Cong Cao
#Upenn ID: 10760059
import random 

def game_intro():
    print('''Tower Blaster is often played with 2 human players, but we will keep this simple and just play
             the user versus the computer. The user’s moves are decided by the user playing the game, by
             asking for input, and the computer’s moves are decided by the program.''')
    
    
    print('''A Tower Blaster game starts with a main pile of 60 bricks, each numbered from 1 to 60.
            The bricks in the main pile are shuffled at the start and both the user and the computer are
            dealt 10 bricks from the main pile. As a player receives each brick, they must place it on top of
            their current tower in the order it is received. Yes, initially your tower is likely to be unstable.
            After the first 10 bricks are dealt to the user and the computer, there will be 40 bricks
            remaining in the main pile. The top brick of the main pile is turned over to begin the discarded
            brick pile.''')
    
    print('''On each player’s turn, the player chooses to pick up the top brick from the discard pile or to
            pick up the top brick from the main pile. The top brick from the discard pile is known. In other
            words, the discard pile is ‘face up’ and everyone knows how wide the top brick is. The main
            pile is ‘face down’. Choosing the top brick from the main pile can be risky, because the player
            does not know what the brick is.
            Once a player chooses a brick, either from the discard pile or from the main pile, the player
            decides where in the tower to put the brick. The tower is always 10 bricks high, so placing a
            brick means that an existing brick in the tower is removed and replaced with the new brick.
            If the player takes a brick from the main pile (the one that is ‘face down’), the player can reject
            it and place it in the discard pile. This means that nothing in that player’s tower changes during
            that turn. If the player takes a brick from the discard pile (the one that is ‘face up’), the player
            MUST place it into the tower.
            The first player to get their 10 bricks in order wins.''')
    




def setup_bricks():
    '''Creates a main pile of 60 bricks, represented as a list containing the integers 1 - 60,
    then creates a discard pile of 0 bricks, represented as an empty list. '''
    
    print('set up blocks')
    discard_pile = []
    main_pile = [i for i in range(1,61)]
    return main_pile, discard_pile


def shuffle_bricks(bricks):
    '''shuffle the given bricks without reutrn anything'''

    print('shuffle bricks')
    random.shuffle(bricks)



def check_bricks(main_pile, discard): 
    '''Check if thre is cards left in the given main pile of bricks, 
    if not shuffle the discard pile and move the bricks to the main pile. 
    Then turn over the top card to be the start of the new discard pile'''
    
    if (len(main_pile)==0):
        print('No brick in the main pile')
        shuffle_bricks(discard)
        for i in range(len(discard)):
            main_pile.append(discard[i])
        discard.clear()
        add_brick_to_discard(get_top_brick(main_pile), discard)
        

    

def check_tower_blaster(tower):
    '''Give a tower, determine if stability has been achieved. and this function returns a boolean value'''
    a = []
    for i in range (len(tower)-1):
        if(tower[i] < tower[i+1]):
            a.append(1)
    if sum(a) ==(len(tower)-1):
        return True
    else:
        return False
        
  
def get_top_brick(brick_pile): 
    '''Remove and return the top brick from any give pile of bricks'''
    top_brick = brick_pile[0]
    brick_pile.remove(brick_pile[0])
    return top_brick
 
   
def deal_initial_bricks(main_pile): 
    '''Start the game by dealing two set of 10 bricks each, from the given main_pile. 
    the function return a tuple containing two leasts, the first one is for the computer hand and the second one is for the player hand'''
    computer = []
    player = []
    for i in range (10):
        a = random.choice(main_pile)
        main_pile.remove(a)
        b = random.choice(main_pile)
        main_pile.remove(b)
        computer.append(a)
        player.append(b)
    
    return computer, player


def add_brick_to_discard(brick, discard): 
    '''Add the given brick to the top of the given discard pile without return anything'''
    discard.insert(0, brick)

def find_and_replace(new_brick, brick_to_be_replaced, tower, discard): 
    '''Find the given brick to be replaced in the give tower and replace it with the given new brick
    Return True if the given brick is replaced, o/w false'''
    if brick_to_be_replaced in tower:
        tower[tower.index(brick_to_be_replaced)] = new_brick
        #tower.replace(brick_to_be_replaced, new_brick)
        add_brick_to_discard(brick_to_be_replaced, discard)
        return True
    else: 
        return False
    
    
    
def computer_play(tower, main_pile, discard):
    '''Computer strategy: the replacement of the number depends on the number in front and behind'''

    print('''COMPUTER's TURN''')
    x = get_top_brick(discard)
    judge1 = False 
    judge2 = False
   
    if (x < tower[1] and tower[0]>tower[1]):
        judge1 = find_and_replace(x, tower[0], tower, discard)
    elif (x > tower[8] and tower[8]>tower[9]):
        judge1 = find_and_replace(x, tower[9], tower, discard)
        
    else: 
        for i in range(8):
            if(tower[i]<x<tower[i+2]==True and tower[i]<tower[i+1]<tower[i+2]==False):
                judge1 = find_and_replace(x,tower[i+1], tower, discard)
                break
                
                
                
    if(judge1 ==False): 
        y = get_top_brick(main_pile)
        if (y < tower[1] and tower[0]>tower[1]):
            judge2 = find_and_replace(y, tower[0], tower, discard)
            
        elif (y > tower[8] and tower[8]>tower[9]):
            judge2 = find_and_replace(y, tower[9], tower, discard)
            
        else: 
            for i in range(8):
                if(tower[i]<y<tower[i+2]==True and tower[i]<tower[i+1]<tower[i+2]==False):
                    judge2 = find_and_replace(y,tower[i+1], tower, discard)
                    break
    
    if (judge1 ==True and judge2 ==False):
        print('The computer picked '+ str(x)+' from the discard pile')
        print('The computer replaced a brick')
        
    elif(judge1==False and judge2==True): 
        print('The computer did not want to pick '+ str(x)+' from the discard pile')
        print('The computer picked the mystery brick '+ str(y)+' from the main pile')
        print('The computer replaced a brick')
        
    elif(judge1 ==False and judge2 ==False): 
        print('The computer did not want to pick '+ str(x)+' from the discard pile')
        print('The computer also did not want to picked the mystery brick '+ str(y)+' from the main pile')
        print('The computer did not replace a brick')
        add_brick_to_discard(x, discard)
        add_brick_to_discard(y, discard)
    return tower
        

def main():
    game_intro()
    
    input('Ready to play?, Type any key to play!')
    # set up the game
    computer_win = False
    player_win= False
    game = True
    
    main_pile, discard_pile = setup_bricks()
    
    shuffle_bricks(main_pile)
    
    computer_brick, player_brick = deal_initial_bricks(main_pile)
    
    add_brick_to_discard(get_top_brick(main_pile), discard_pile)
    # start playing the game
    while(game == True):
        
        check_bricks(main_pile, discard_pile)
        
        computer_brick = computer_play(computer_brick, main_pile, discard_pile)
        computer_win = check_tower_blaster(computer_brick)
        if (computer_win == True): 
            print('computer win!')
            print('computer tower: ' + str(computer_brick))
            game ==False
            continue
    
        
        # player's turn
        input('Type any key to continue:')
        print('''NOW IT'S YOUR TURN''')
        
        print('Your Tower: ' + str(player_brick))
        number1 = get_top_brick(discard_pile)
        print('The top brick on the discard pile is ' +str(number1))
        print('Type D to take the discard brick, M to for a mystery brick, or H for help')
        choose1 = True
        choose2 =True
        choose3 =True 
        choose4 = True
        
        
        while(choose1 ==True):
            enter1 = input()
            if(enter1 =='D' or enter1 =='d'):
                print('you picked ' + str(number1) +' from the discard pile')
                print('Where do you want to place this brick? Type a brick number to replace in your tower')
                
                n = input()
                TF = find_and_replace(number1, int(n), player_brick, discard_pile)
                while(choose3 ==True): 
                    if(TF == True): 
                        print('you replced ' + n + ' with ' + str(number1))
                        choose3 == False
                        break
                    else: 
                        print('wrong input, please try again')
                        n = input()
                        TF = find_and_replace(number1, int(n), player_brick, discard_pile)   
                choose1 = False
                
                
            elif(enter1=='M' or enter1 =='m'): 
                add_brick_to_discard(number1, discard_pile)
                
                
                number2 = get_top_brick(main_pile)
                print('you picked ' + str(number2) +' from the main pile')
                print('''Do you want to use this brick? Type 'Y' or 'N' to skip turn''')
               
                while(choose2 ==True):
                    enter2 =input()
                    if(enter2 =='Y' or enter2 =='y'):
                        print('you picked ' + str(number2) +' from the main pile')          
                        print('Where do you want to place this brick? Type a brick number to replace in your tower')                
                        n1 = input()
                        TF1 = find_and_replace(number2, int(n1), player_brick, discard_pile)
                 
                        while(choose4 ==True): 
                            if(TF1 ==True): 
                                print('you replced ' + n1 + ' with ' + str(number2))
                                choose4 ==False
                                break
                            else: 
                                print('wrong input, please try again')
                                n1 = input()
                                TF1 = find_and_replace(number2, int(n1), player_brick, discard_pile)

                        choose1 =False
                        choose2=False

                    elif(enter2 =='N' or enter2 =='n'):
                        choose1 = False
                        choose2 = False
                        add_brick_to_discard(number2, discard_pile)
                        print('You did not replace a brick')
                    else: 
                        print('Wrong input, please try to enter again')        

            elif(enter1=='h' or enter1 =='H'):
                print('''If you enter D, it means you will take the brick in discard pile to build your tower. ''')
                print('''If you enter M, you will see the brick in the 'face down' main pile and deciside whether or not your want to use this brick to build your tower.''')
                print('Type D to take the discard brick, M to for a mystery brick.')
            else:
                print('Wrong input, please try to enter again')

        print('Your Tower: ' + str(player_brick)) 
    
        
    
            
            
        player_win = check_tower_blaster(player_brick)
        if (player_win ==True):
            print('player win!')
            print('player tower: ' + str(player_brick))
            game =='False'
            break
            
    
   

if __name__ == "__main__":
    main()
    


