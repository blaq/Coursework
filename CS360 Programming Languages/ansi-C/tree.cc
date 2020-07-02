#include "tree.h"

int main (int arg, char** args)
{
	BinaryTree tree;
	node* oak_tree = NULL;
	node* subtree = NULL;
	node* print = NULL;
	std::string data = "";
	int key  = 0, option = 0;


	do
	{	// Prints out instructions to the user
		std::cout << "\n\tPlease chose an option.";
		std::cout << "\n\tOption 1: insert data into the tree.";
		std::cout << "\n\tOption 2: remove data from the tree.";
		std::cout << "\n\tOption 3: display data at a node.";
		std::cout << "\n\tOption 4: Print tree nodes inorder.";
		std::cout << "\n\tOption 5: Print tree nodes in preorder.";
		std::cout << "\n\tOption 6: Print tree nodes in postorder.";
		std::cout << "\n\tOption 7: Deleate everything in the tree.";
		std::cout << "\n\tOption 0: enter \"0\" to exit.\n: ";

		std::cin >> option;
		// Switch statment used to interact with the user
		switch (option)
		{
			case 1:// Case 1 inserts a node
				std::cout <<"\nEnter data to be put into the binary tree.\n: ";
				std::cin >> data;
				std::cout <<"\nEnter ID to be associated with the node.\n: ";
				std::cin >> key;

				if (oak_tree == NULL)
					oak_tree = tree.insertNode(oak_tree, data, key);
				else
					tree.insertNode(oak_tree, data, key);
				break;

			case 2: // Case 2 removes a node
				std::cout <<"\nEnter data location to be removed.\n: ";
				std::cin >> key;
				oak_tree = tree.removeNode(oak_tree, key);
				//tree.insertNode(oak_tree, subtree -> data, subtree -> key_value);
				break;

			case 3:// Case 3 prints a node
				std::cout << "\nPlease select a node to print\n: ";
				std::cin >> key;
				print = tree.search(oak_tree, key);

				if (print != NULL)// MIGHT BRACK HERE
				{
					std::cout << "\nNode key value: " << print -> key_value;
					std::cout << "\nNode data: " << print -> data << std::endl;
				}
				else{
					std::cout << "\nError not a node!" << std::endl;
				}
				break;
			case 4:
				tree.inOrder(oak_tree);
				break;
			case 5:
				tree.preOrder(oak_tree);
				break;

			case 6:
				tree.postOrder(oak_tree);
				break;
			case 7:
				tree.destroy_tree(oak_tree);
				break;

			case 0:// If the user wants to quit
				std::cout << "\nExiting. . .." << std::endl;
				break;

			default:// Handles odd input
				std::cout <<"\nInvalid input.\n";
		}

	} while (option != 0);// Exit the loop if the user picks int 0

	tree.destroy_tree(oak_tree);
	return 0;
}
