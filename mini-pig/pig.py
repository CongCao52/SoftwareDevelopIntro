from random import randint

def print_instructions():
    '''Prints the rules of the game.
    '''

    # TODO Insert your code here
    print('welcome to the pig game!')
    print('''You and computer take turns; on each turn, a player rolls a six-side dice as many times as she wishes, or untill she rolls a 6. each number she roll, 
          except a 6, is added to her score this turn; but if she rolls a 6, her score of this turn is zero, and her turn ends. At the end of each turn, the score
          for that turn is added to the player total score. the first player to reach or exceed 50 wins''')

    
def computer_move(computer_score, human_score):
    '''Has the computer roll some number of times, displays the result of each roll, and
    returns the result (either 0 or the total value of the rolls).
    Uses the given arguments to play more intelligently.
    If human score is higher than the computer score, computer will take the risk to roll more 
    If human score is lower than the compter score, computer will play more safely.  
    '''

# TODO Insert your code here
    input('Now is computer turn (press any key) ')
    if (computer_score>human_score):
        times = randint(1,4)
    else:
        times =randint(4,7)
     
    rolling =roll()    
    count =0    
    if rolling !=6:
        count = rolling
        for i in range(times): 
            rolling =roll ()
            if(rolling!=6):
                count = count +rolling
            else:
                break
    print(str(count) +' is add to computer score')
    return computer_score+count, human_score

    
    
def human_move(computer_score, human_score):
    '''Repeatedly asks whether the user wants to roll again and displays the result of each roll.

    - If the user chooses to roll again, and DOES NOT roll a 6, this function adds the roll
    to the total of the rolls made during this move.
    - If the user chooses to roll again, and DOES roll a 6, the function returns 0.
    - If the user chooses not to roll again, the function returns the total of the rolls made during this move.
    '''

    # TODO Insert your code here
    input('Now is your turn (press any key) ')
    
    rolling = roll()
    
    print('Your first roll is ' + str(rolling))
    count = 0
    if (rolling == 6):
        print('Your turn ends')
        print(str(count) +' is add to your score')
        return computer_score, human_score
    else:
        loop = True
        while(loop==True):   
            print('Do you want to roll again? (y/n)')
            tf = input()
            if (ask_yes_or_no(tf)==True):
                rolling =roll()
                print('Your roll is ' + str(rolling))
                if(rolling ==6):
                    count = 0
                    print('Your turn ends since you roll a 6')
                    break
                else:
                    count =count+rolling
            elif(ask_yes_or_no(tf)==False):
                break
        print(str(count) +' is add to your score')
        return computer_score, human_score+count
                    
    
    

def is_game_over(computer_score, human_score):
    '''Returns True if either player has 50 or more, and the players are not tied,
    otherwise it returns False.
    '''
    # TODO Insert your code here
    if(computer_score>=50 or human_score>=50):
        if(human_score == computer_score):
            return False
        else:
            return True        
    else:
        return False
        
 

def roll():
    '''Returns a random number in the range 1 to 6, inclusive.
    '''
    # TODO Insert your code here
    number = randint(1,6)
    return number


def ask_yes_or_no(prompt):
    '''Prints the given prompt as a question to the user, for example, "Roll again? (y/n) ".

    - If the user responds with a string whose first character is 'y' or 'Y', returns True.
    - If the user responds with a string whose first character is 'n' or 'N', returns False.
    - Any other response causes the question to be repeated until the user provides an acceptable response.
    '''

    # TODO Insert your code here 
    game = True
    while(game == True):
        
        if(prompt =='y' or prompt=='Y'): 
            game==False
            return True
            
        elif (prompt =='n' or prompt =='N'):
            game==False
            return False
                    
        else: 
            print('wrong input, please try again')
            print('Rolling again? (y/n)')
            prompt = input()

 

def show_current_status(computer_score, human_score):
    '''Tells the user both her current score and the computer's score, and how far
    behind (or ahead) she is, or if there is a tie.
    '''

    # TODO Insert your code here
    print('Your current score: '+ str(human_score) +' ; '+ 'Computer Score: ' + str(computer_score)+' .')
    if (computer_score == human_score):
        print('There is a tie')
    elif(computer_score > human_score):
        print('The user is ' + str(computer_score-human_score)+' behind the computer' )
    else: 
        print('The user is ' + str(human_score-computer_score)+' ahead the computer' )


def show_final_results(computer_score, human_score):
    '''Tells the user whether she won or lost, and by how much.
    '''

    # TODO Insert your code here
    if(computer_score > human_score):
        print('The computer win !')
        print('Computer Score: '+str(computer_score))
        print('Human Score: '+str(human_score))
        print('The user is ' +str(computer_score-human_score) + ' behind the computer')
        
    else:
        print('You win !')
        print('Computer Score: '+str(computer_score))
        print('Human Score: '+str(human_score))
        print('The user is ' +str(human_score-computer_score) + ' ahead the computer')
            
    
    
def main():

    print_instructions()

    game_running = True
    while game_running:

        #to start the game
        input('Ready to play? (press any key) ')

        #set initial scores
        human_score = 0
        computer_score = 0

        # TODO Insert the rest of code here
        
        while (is_game_over(computer_score, human_score)==False): 
            # call function to make a computer move
            computer_score,human_score= computer_move(computer_score, human_score)
            #show status
            show_current_status(computer_score, human_score)
            # call function to make a human move
            computer_score,human_score= human_move(computer_score, human_score)
            #show status
            show_current_status(computer_score, human_score)
        # show final status
        show_final_results(computer_score, human_score) 
        
        # loop to ask whether the player want to play the game again or not. 
        print('Do you want to play the game again? y/n')
        playing = True
        while playing:
            result = input()
            if (result == 'Y' or result == 'y'):
                print('great, let us start the game again !')
                break
            elif (result == 'N' or result == 'n'):
                print('Thanks for playing !')
                game_running = False
                break 
            else: 
                print('wrong input, please try again')
                
        
            
        

if __name__ == '__main__':
    main()