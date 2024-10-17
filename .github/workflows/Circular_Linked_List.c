#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};
struct node *tail=NULL;

void insertlast();
void insertfirst();
void deletefirst();
void deletelast();
void display();

void main()
{
    int choice;
    printf("1.Insertlast\n2.InsertFirst\n3.Deletefisrt\n4.Deletelast\n5.Display\n6.Exit\n\n");
    while(1)
    {
        printf("Enter your choice:");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:
            insertlast();
            break;
            case 2:
            insertfirst();
            break;
            case 3:
            deletefirst();
            break;
            case 4:
            deletelast();
            break;
            case 5:
            display();
            break;
            case 6:
            exit(0);
            break;
            default:
            printf("Enter valid choice\n\n");
        }
    }
}
void insertlast()
{
    struct node *ptr;
    ptr=(struct node*)malloc(sizeof(struct node));
    printf("Enter value:");
    scanf("%d",&ptr->data);
    if(tail==NULL)
    {
        tail=ptr;
        tail->next=tail;
    }
    else
    {
        ptr->next=tail->next;
        tail->next=ptr;
        tail=ptr;
    }
    printf("Node inserted at last sucessfully\n");
}
void insertfirst()
{
    struct node *ptr;
    ptr=(struct node*)malloc(sizeof(struct node));
    printf("Enter value:");
    scanf("%d",&ptr->data);
    if(tail==NULL)
    {
        tail=ptr;
        tail->next=tail;
    }
    else
    {
        ptr->next=tail->next;
        tail->next=ptr;
        
    }
    printf("Node inserted at fisrt sucessfully\n");
}
void deletefirst()
{
    struct node *temp;
    temp=tail->next;
    if(tail==NULL)
    {
        printf("Empty listd, Can't delete\n");
    }
    else if(tail->next==tail)
    {
        tail=NULL;
        
    }
    else
    {
        temp=tail->next;
        tail->next=temp->next;
        free(temp);
        printf("Node deleted at first sucessfully\n");
    }
}
void deletelast()
{
    struct node *temp,*current;
    temp=tail->next;
    if(tail==NULL)
    {
        printf("Empty listd, Can't delete\n");
    }
    else if(tail->next==tail)
    {
        
        free(temp);
        tail=NULL;
    }
    else
    {
        temp=tail->next;
        if(temp->next!=tail->next)
        {
            temp=temp->next;
        }
        current=tail;
        temp->next=tail->next;
        tail=temp;
        free(current);
        printf("Node dleted sucessfully\n");

    }
}
void display()
{
    struct node *temp;
    
    if(tail==NULL)
    {
        printf("List is emptu\n");
    }
    else
    {
        temp=tail->next;
        while(temp->next!=tail->next)
        {
            printf("%d\t",temp->data);
            temp=temp->next;
        }
        printf("%d\n",temp->data);
    }
}
