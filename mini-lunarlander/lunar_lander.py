# Header
'''
Name:Cong Cao 
Penn ID: 10760059
Statement of Work: I worked alone without help 
Inputs that leads to a 'Win': 
    [6,7,8,1,2,3,1,1,2,6,10,10,10,10,23]
Inputs that leads to a 'loss':
    [10,20,70,20,0,0,0,0,0,0,0,0,0,0,0,0,0,-5,0,0,0,0,0]

'''
game_running = True

#while loop: while condition is met, run code block inside loop
#while game_running is True, run code block inside loop
while (game_running):

    # set default values
    altitude = 100.0  # meters
    velocity = 0.0  # meters/second
    fuel = 100.0  # liters
    seconds = 0  # seconds
    
    print('Welcome to Lunar lander!')
    print('Initial Alititude: ' + str(altitude) + ' meters')
    print('Initial Velocity: '+ str(velocity) + ' m/s')
    print('Initial Fuel: ' +str(fuel) + ' liters')    

    #while altitude > 0, run code block inside loop
    while (altitude > 0):

        #'pass' is a null statement -- it does nothing.  it serves as a placeholder for code to be written.
        #Replace 'pass' with your code here
        # write your your code for the steps above
        # it will run indefinitely as long as altitude > 0
        # Get the number input
        print('How much fuel to burn in next second?')
        number = input() 
        try:
            # determine the type of number entered
            q = float(number) 
            if (q <= 0):
                q = 0
            elif(q>= fuel):
                q =fuel
            # get the fuel, velocity, altitude and seconds stats
            fuel = fuel - q
            velocity = velocity + 1.6 - q * 0.15
            altitude = altitude - velocity
            seconds= seconds+1 
            print('Current Alititude: ' + str(round(altitude,2)) + ' meters')
            print('Current Velocity: ' + str(round(velocity,2)) + ' m/s')
            print('Current Fuel: ' + str(fuel) + ' liters')
            print('Total Time Elapsed ' +str(seconds)+' Seconds')
            
        # catch the error if the number entered is not float or int    
        except ValueError:
            print('Invalid number, please enter the fuel number again')
        
    
    # determine whether the land is safe or not
    if velocity<10:
        print('The landing is safe')
    else:
        print('The landing is not safe')
    # print the stats    
    print('At what velocity the landing occured: '+str(round(velocity,3))+' m/s')
    print('How much seconds the landing took: '+str(seconds)+ ' seconds')
    print('How much fuel is left: '+str(fuel) + ' fuel is left')
    
    # ditermine whether we will play again or not
    print('Do you want to play this game again? (Y/y if Yes, others if no.)')
    TF = input()
    
    if TF != 'Y' and TF!='y':
        game_running = False
    else:
        print('Great, let us play it again ! ')
