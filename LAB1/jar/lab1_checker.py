import os
exec_strs = [
    "java -jar LAB1.jar 1 -r testcase.csv -s out1_0.csv",
    "java -jar LAB1.jar 1 -r testcase.csv -g dimfq@gmail.com > out1_1.csv",
    "java -jar LAB1.jar 1 -r testcase.csv -s out1_2.csv -a ack@gmail.com 992764",
    "java -jar LAB1.jar 1 -r testcase.csv -s out1_3.csv -d tsziz@gmail.com",
    "java -jar LAB1.jar 1 -r testcase.csv -s out1_4.csv -u rbzpqykqu@gmail.com 999999",
    "java -jar LAB1.jar 1 -r testcase.csv -s out1_5.csv -dt",
    "java -jar LAB1.jar 1 -r testcase.csv -t > out1_6.csv",
    "java -jar LAB1.jar -h > out1_7.csv",
    # "java -jar LAB1.jar 2 https://www.journaldev.com/629/java-catch-multiple-exceptions-rethrow-exception out_1.csv",
    # "java -jar LAB1.jar 2 https://github.com/tieuminh2510/SE1420-CSD201/tree/master/LAB1 out_1.csv",
]
your_point = 0;
for index, exec_str in enumerate(exec_strs):
    os.system(exec_str)
    with open("out1_" + str(index) + ".csv") as output:
        content = output.readlines()
        if index == 0:
            print("Check the queue with testcase.csv:")
            try:
                with open("lab1_" + str(index) + ".csv") as basefile:
                    base_content = basefile.readlines()
                    flag = True
                    for i, line in enumerate(base_content):
                        base_rows = line.strip().split(",")
                        rows = content[i].strip().split(",")
                        if base_rows[0] != rows[0] or base_rows[1] != rows[1]:
                            flag = False
                            break
                    if flag:
                        your_point += 0.5
                        print("Your answer is correct")
                        print("Your points = " + str(your_point))
                    else:
                        print("Your answer is not correct")
                        print("Your points = " + str(your_point))
            except expression as identifier:
                    print("Your answer has an error")
                    print("Your points = " + str(your_point))                    
        elif index == 1:
            with open("lab1_" + str(index) + ".csv") as basefile:
                base_content = basefile.readlines()
                print("Check get point with email is dimfq@gmail.com:")
                try:
                    point = int(content[0])
                    base_point = int(base_content[0])
                    if point == base_point:
                        your_point += 0.5
                        print("Your answer is correct")
                        print("Your points = " + str(your_point))
                    else:
                        print("Your answer is not correct")
                        print("Your points = " + str(your_point))
                except expression as identifier:
                    print("Your answer has an error")
                    print("Your points = " + str(your_point))
        elif index == 2:
            print("Check add ack@gmail.com 992764:")
            try:
                with open("lab1_" + str(index) + ".csv") as basefile:
                    base_content = basefile.readlines()
                    flag = True
                    for i, line in enumerate(base_content):
                        base_rows = line.strip().split(",")
                        rows = content[i].strip().split(",")
                        if base_rows[0] != rows[0] or base_rows[1] != rows[1]:
                            flag = False
                            break
                    if flag:
                        your_point += 0.5
                        print("Your answer is correct")
                        print("Your points = " + str(your_point))
                    else:
                        print("Your answer is not correct")
                        print("Your points = " + str(your_point))
            except expression as identifier:
                    print("Your answer has an error")
                    print("Your points = " + str(your_point))    
        elif index == 3:
            print("Check delete tsziz@gmail.com:")
            try:
                with open("lab1_" + str(index) + ".csv") as basefile:
                    base_content = basefile.readlines()
                    flag = True
                    for i, line in enumerate(base_content):
                        base_rows = line.strip().split(",")
                        rows = content[i].strip().split(",")
                        if base_rows[0] != rows[0] or base_rows[1] != rows[1]:
                            flag = False
                            break
                    if flag:
                        your_point += 0.5
                        print("Your answer is correct")
                        print("Your points = " + str(your_point))
                    else:
                        print("Your answer is not correct")
                        print("Your points = " + str(your_point))
            except expression as identifier:
                    print("Your answer has an error")
                    print("Your points = " + str(your_point))
        elif index == 4:
            print("Check update rbzpqykqu@gmail.com 999999:")
            try:
                with open("lab1_" + str(index) + ".csv") as basefile:
                    base_content = basefile.readlines()
                    flag = True
                    for i, line in enumerate(base_content):
                        base_rows = line.strip().split(",")
                        rows = content[i].strip().split(",")
                        if base_rows[0] != rows[0] or base_rows[1] != rows[1]:
                            flag = False
                            break
                    if flag:
                        your_point += 0.5
                        print("Your answer is correct")
                        print("Your points = " + str(your_point))
                    else:
                        print("Your answer is not correct")
                        print("Your points = " + str(your_point))
            except expression as identifier:
                    print("Your answer has an error")
                    print("Your points = " + str(your_point))
        elif index == 5:
            print("Check delete top of queue:")
            try:
                with open("lab1_" + str(index) + ".csv") as basefile:
                    base_content = basefile.readlines()
                    flag = True
                    for i, line in enumerate(base_content):
                        base_rows = line.strip().split(",")
                        rows = content[i].strip().split(",")
                        if base_rows[0] != rows[0] or base_rows[1] != rows[1]:
                            flag = False
                            break
                    if flag:
                        your_point += 0.5
                        print("Your answer is correct")
                        print("Your points = " + str(your_point))
                    else:
                        print("Your answer is not correct")
                        print("Your points = " + str(your_point))
            except expression as identifier:
                    print("Your answer has an error")
                    print("Your points = " + str(your_point))
        elif index == 6:
            with open("lab1_" + str(index) + ".csv") as basefile:
                base_content = basefile.readlines()
                print("Check get top of queue:")
                try:
                    point = int(content[0])
                    base_point = int(base_content[0])
                    if point == base_point:
                        your_point += 0.5
                        print("Your answer is correct")
                        print("Your points = " + str(your_point))
                    else:
                        print("Your answer is not correct")
                        print("Your points = " + str(your_point))
                except expression as identifier:
                    print("Your answer has an error")
                    print("Your points = " + str(your_point))
        elif index == 7:
            print("Check help information:")
            try:
                if "Help" in content[0] or "help" in content[0]:
                    your_point += 0.5
                    print("Your answer is correct")
                    print("Your points = " + str(your_point))
                else:
                    print("Your answer is not correct")
                    print("Your points = " + str(your_point))
            except expression as identifier:
                print("Your answer has an error")
                print("Your points = " + str(your_point))
