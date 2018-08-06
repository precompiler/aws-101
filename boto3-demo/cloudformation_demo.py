import boto3

client = boto3.client("cloudformation")

with open("templates/network.yaml", "r") as file:
    body = file.read()
stack_name = "cf-demo-vpc-stack"
response = client.create_stack(
    StackName=stack_name,
    TemplateBody=body,
    Parameters=[
        {
            "ParameterKey": "Name",
            "ParameterValue": "Demo"
        },
        {
            "ParameterKey": "VpcCIDR",
            "ParameterValue": "10.0.0.0/16"
        },
        {
            "ParameterKey": "Subnet1CIDR",
            "ParameterValue": "10.0.1.0/24"
        },
        {
            "ParameterKey": "Subnet2CIDR",
            "ParameterValue": "10.0.2.0/24"
        }
    ]
)

print("Creating Stack: {}...".format(response.get("StackId")))
waiter = client.get_waiter("stack_create_complete")
waiter.wait(
    StackName=stack_name,
    WaiterConfig={
        'Delay': 10
    }
)
print("Stack Created...")