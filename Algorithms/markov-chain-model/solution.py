# The code comment has been written by chat gpt, the algorithm 

def markov_chain(E0, M0, time_periods):
    # Nested function g handles the iterative matrix multiplication
    def g(E0, M0, time_periods):
        # Transition matrix T which defines the probability of moving between states A and B
        T = [[0.5, 0.5],  # Row 0: Probabilities of moving from A to A (0.5) and A to B (0.5)
             [0.25, 0.75]]  # Row 1: Probabilities of moving from B to A (0.25) and B to B (0.75)
        
        # Initial values for region A and region B
        A = E0  # Initial market share or value for region A
        B = M0  # Initial market share or value for region B

        # Loop over the number of time periods to apply matrix multiplication
        for i in range(time_periods):
            # Calculate the new values for A and B after each time step
            new_A = T[0][0] * A + T[0][1] * B  # New value of A after transition
            new_B = T[1][0] * A + T[1][1] * B  # New value of B after transition
            
            # Update A and B for the next iteration
            A, B = new_A, new_B

            # Print the updated values of A and B after each iteration
            print(f"After iteration {i+1}: E = {A:.4f}, M = {B:.4f}")

        # Return the final values of A and B after all iterations
        return A, B

    # Call the nested function g to compute the final market shares
    A, B = g(E0, M0, time_periods)

    # Print the final result after all iterations
    print(f"Final market shares after {time_periods} iterations:")
    print(f"Region A = {A:.4f}, Region B = {B:.4f}")

# Example usage of the function with initial values E0=0.6, M0=0.4, and 10 time periods
markov_chain(0.6, 0.4, 10)
