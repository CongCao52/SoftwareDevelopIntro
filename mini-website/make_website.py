

def read_file(resume_file):
  '''Read the text file'''
  with open(resume_file) as file:
      d = [line.rstrip().lstrip() for line in file]
  return d


def get_name(info):
    '''Get the name of the resume, return "Invalid Name" if the name is invalid'''
    import string
    have_name = True
    name = info[0]
    if (len(name) == 0):
        have_name = False
    else:
        if (name[0] not in string.ascii_letters or name[0].islower()):
            have_name = False
    if have_name == False:
        name = 'Invalid Name!'
    return name


def get_project(info):
    '''Get the project in the resume text, and return a list of string with projects'''
    project = []
    for i in range(len(info) - 1):
        line = info[i]
        if line.startswith('Projects'):
            for j in range(i + 1, len(info) - 1):
                pro = info[j].strip()
                if '------------------------------' not in pro:
                    if pro != '':
                        project.append(pro)
            break
    return project


def get_email(info):
    '''Get the email in the resume text, and return the string of email as output'''
    email_output ='Invalid'
    for i in info:
        if '@' in i: 
            end_four = i[-4:]
            loc = i.index('@')
            if(end_four=='.edu'or end_four =='.com'):
                end_four_index = i.index(end_four)
                
                
                length = i[loc+1:end_four_index]
                if(length[0].isalpha() and length[0].islower()):
                    legal = True 
                    for j in length: 
                        if(j.isnumeric()==True): 
                            legal =False
                            break
                    if(legal ==True): 
                        name = i[0:loc]
                        if name.isalpha():
                            email_output = i 
                            break                         
    return email_output


def get_course(info):
    '''get the courses in the resume text, and return a list of courses in string'''
    course = []

    for i in range(len(info)):
        line = info[i]
        if line.startswith('Courses'):
            course_string = line[i + 7:]
            char = -1
            for j in course_string:
                if j.isalpha():
                    char = course_string.index(j)
                    break
            if (char > -1):
                course_string = course_string[char:]
                course = course_string.split(',')
                course = strip_list(course)

    return course


def surround_block(tag, text):
    """
    Surrounds the given text with the given html tag and returns the string.
    """

    # insert code
    return '<{}>{}</{}>'.format(tag, text, tag)


def comma_separated_list(lst):
    '''use comma to separated the list and return a list'''
    lst_str = ', '.join(lst)
    return lst_str


def strip_list(lst):
    '''strip the list'''
    lst_strip = [i.strip() for i in lst]
    return lst_strip


def write_html(name, email_address, projects, courses, output1):
    '''Write all the html file into the template html file with no returns'''
    file_r = open('resume_template.html','r')
    lines = file_r.readlines()
    file_r.close()
    del lines[-1]
    del lines[-1]
    lines.append('<div id="page-wrap">')
    
    #write name and address in html format
    name = surround_block('h1', name)
    email_link = create_email_link(email_address)
    email_address = surround_block('p','Email: '+email_link)
    info_html = surround_block('div',name+email_address)
    lines.append(info_html)

    #write project in html format
    p_header =surround_block('h2','Projects')
    p_list = ''
    for i in projects:
        p = surround_block('li',i)
        p_list = p_list + p
    p_list1 = surround_block('ul', p_list)
    p_list2 = surround_block('div',p_header + p_list1)
       
    lines.append(p_list2)

    #write courses in html format
    c_header = surround_block('h3','Courses')
    lst = comma_separated_list(courses)
    c_span = surround_block('spam', lst)
    course_html = surround_block('div', c_header + c_span)  
        
    lines.append(course_html)
    lines.append('</div>')
    lines.append('</body>')
    lines.append('</html>')
    fout= open(output1,'w')
    fout.writelines(lines)
    fout.close()
    


def create_email_link(email_address):
    '''create a email link in the html format'''
    front = '''a href="mailto:''' + email_address + '''"'''
    text = []
    for i in email_address:
        if i == '@':
            text.append('[aT]')
        else:
            text.append(i)
    joint = "".join(text)
    out = '<{}>{}</{}>'.format(front, joint, 'a')
    return out


def generate_html(txt_input_file, html_output_file):
    """
    Loads given txt_input_file,
    gets the name, email address, list of projects, and list of courses,
    then writes the info to the given html_output_file.

    # Hint(s):
    # call function(s) to load given txt_input_file
    # call function(s) to get name
    # call function(s) to get email address
    # call function(s) to get list of projects
    # call function(s) to get list of courses
    # call function(s) to write the name, email address, list of projects, and list of courses to the given html_output_file
    """

    # insert code
    d1 = read_file(txt_input_file)
    name = get_name(d1)
    email = get_email(d1)
    project = get_project(d1)
    course = get_course(d1)
    write_html(name, email, project, course, html_output_file)


def main():
    # DO NOT REMOVE OR UPDATE THIS CODE

    generate_html('resume.txt', 'resume_template.html')

    # Uncomment each call to the generate_html function when you’re ready
    # to test how your program handles each additional test resume.txt file
    generate_html('TestResumes/resume_bad_name_lowercase/resume.txt', 'TestResumes/resume_bad_name_lowercase/resume.html')
    generate_html('TestResumes/resume_courses_w_whitespace/resume.txt', 'TestResumes/resume_courses_w_whitespace/resume.html')
    generate_html('TestResumes/resume_courses_weird_punc/resume.txt', 'TestResumes/resume_courses_weird_punc/resume.html')
    generate_html('TestResumes/resume_projects_w_whitespace/resume.txt', 'TestResumes/resume_projects_w_whitespace/resume.html')
    generate_html('TestResumes/resume_projects_with_blanks/resume.txt', 'TestResumes/resume_projects_with_blanks/resume.html')
    generate_html('TestResumes/resume_template_email_w_whitespace/resume.txt', 'TestResumes/resume_template_email_w_whitespace/resume.html')
    generate_html('TestResumes/resume_wrong_email/resume.txt', 'TestResumes/resume_wrong_email/resume.html')

    # If you want to test additional resume files, call the generate_html function with the given .txt file
    # and desired name of output .html file


if __name__ == '__main__':
    main()

    
    
    