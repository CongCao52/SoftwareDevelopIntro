# -*- coding: utf-8 -*-
"""
Created on Mon Feb 15 20:18:08 2021

@author: congc
"""

import unittest

from make_website import *

class MakeWebsite_Test(unittest.TestCase):

    def test_surround_block(self):

        # test surrounding html
        self.assertEqual(surround_block('h1', 'Eagles'), "<h1>Eagles</h1>")

        # test surrounding html
        self.assertEqual(surround_block('p', 'Lorem ipsum dolor sit amet, consectetur ' +
                                        'adipiscing elit. Sed ac felis sit amet ante porta ' +
                                        'hendrerit at at urna. Donec in vehicula ex. Aenean ' +
                                        'scelerisque accumsan augue, vitae cursus sapien venenatis ' +
                                        'ac. Quisque dui tellus, rutrum hendrerit nisl vitae, ' +
                                        'pretium mollis lorem. Pellentesque eget quam a justo ' +
                                        'egestas vehicula in eu justo. Nulla cursus, metus vitae ' +
                                        'tincidunt luctus, turpis lectus bibendum purus, eget ' +
                                        'consequat est lacus ac nibh. In interdum metus vel est ' +
                                        'posuere aliquet. Maecenas et euismod arcu, eu auctor ' +
                                        'libero. Phasellus lectus magna, auctor ac auctor in, ' +
                                        'suscipit id turpis. Maecenas dignissim enim ac justo ' +
                                        'tincidunt viverra. Sed interdum molestie tincidunt. Etiam ' +
                                        'vitae justo tincidunt, blandit augue id, volutpat ligula. ' +
                                        'Aenean ut aliquet mi. Suspendisse consequat blandit posuere.'),
                                        '<p>Lorem ipsum dolor sit amet, consectetur ' +
                                        'adipiscing elit. Sed ac felis sit amet ante porta ' +
                                        'hendrerit at at urna. Donec in vehicula ex. Aenean ' +
                                        'scelerisque accumsan augue, vitae cursus sapien venenatis ' +
                                        'ac. Quisque dui tellus, rutrum hendrerit nisl vitae, ' +
                                        'pretium mollis lorem. Pellentesque eget quam a justo ' +
                                        'egestas vehicula in eu justo. Nulla cursus, metus vitae ' +
                                        'tincidunt luctus, turpis lectus bibendum purus, eget ' +
                                        'consequat est lacus ac nibh. In interdum metus vel est ' +
                                        'posuere aliquet. Maecenas et euismod arcu, eu auctor ' +
                                        'libero. Phasellus lectus magna, auctor ac auctor in, ' +
                                        'suscipit id turpis. Maecenas dignissim enim ac justo ' +
                                        'tincidunt viverra. Sed interdum molestie tincidunt. Etiam ' +
                                        'vitae justo tincidunt, blandit augue id, volutpat ligula. ' +
                                        'Aenean ut aliquet mi. Suspendisse consequat blandit posuere.</p>')

    def test_create_email_link(self):

        # test created email 
        self.assertEqual(
            create_email_link('lbrandon@wharton.upenn.edu'),
            '<a href="mailto:lbrandon@wharton.upenn.edu">lbrandon[aT]wharton.upenn.edu</a>')

        # test created email
        self.assertEqual(
            create_email_link('lbrandon.at.wharton.upenn.edu'),
            '<a href="mailto:lbrandon.at.wharton.upenn.edu">lbrandon.at.wharton.upenn.edu</a>')
    
    def test_read_file(self):
        
        #test read_file function
        self.assertEqual(read_file('resume.txt'),['I.M. Student',
            'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
            'Projects',
            'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
            'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
            '------------------------------',
            'tonyl@seas.upenn.edu'])
        

    def test_get_name(self):
        # test get name function 
        lines = ['I.M. Student',
                 'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                 'Projects',
                 'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                 'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                 '------------------------------',
                 'tonyl@seas.upenn.edu\n']
        
        lines_test = ['  brandon (name lowercase)',
                'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                'Projects',
                'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                '------------------------------',
                'lbrandon@wharton.upenn.edu']
        
        # test get_name function 
        self.assertEqual(get_name(lines),'I.M. Student')
        
        # test get get name function invalid name
        
        self.assertEqual(get_name(lines_test),'Invalid Name!')
        
    def test_get_email(self):
        # test get email function 
        lines = ['I.M. Student',
                 'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                 'Projects',
                 'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                 'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                 '------------------------------',
                 'tonyl@seas.upenn.edu']
        
        lines_test1 = ['Brandon (email w/ whitespace)',
                      'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                      'Projects',
                      'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                      'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                      '------------------------------',
                      'tlbrandon@wharton4.upenn.edu    ']
        
        lines_test2 = ['Brandon (wrong email)',
                     'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                     'Projects',
                     'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                     'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                     '------------------------------',
                     'lbrandon4@wharton.upenn.edu']
        lines_test3 = ['Brandon (wrong email)',
                     'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                     'Projects',
                     'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                     'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                     '------------------------------',
                     'lbrandon@wharton.upenn.edu   ']
        lines_test4 = ['Brandon (wrong email)',
                     'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                     'Projects',
                     'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                     'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                     '------------------------------',
                     'lbrandon@wharton.upenn.sss']
        
        # test get email function 
        self.assertEqual(get_email(lines),'tonyl@seas.upenn.edu')
        
        # test get email function  Invalid email
        self.assertEqual(get_email(lines_test1),'Invalid')
        self.assertEqual(get_email(lines_test2),'Invalid')
        self.assertEqual(get_email(lines_test3),'Invalid')
        self.assertEqual(get_email(lines_test4),'Invalid')
        
    def test_get_project(self):
        # test get project function
        lines = ['I.M. Student',
                 'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                 'Projects',
                 'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                 'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                 '------------------------------',
                 'tonyl@seas.upenn.edu']
        lines_test1 = ['Brandon (projects w/ whitespace)',
                     'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                     'Projects',
                     '         CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                     'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                     '------------------------------',
                     'lbrandon@wharton.upenn.edu']
        
        self.assertEqual(get_project(lines),['CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.', 'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)'])
        # test get project function with space
        self.assertEqual(get_project(lines_test1),['CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.', 'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)'])

    def test_get_course(self):
        # test get course function
        lines = ['I.M. Student',
                 'Courses :- Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                 'Projects',
                 'CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                 'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                 '------------------------------',
                 'tonyl@seas.upenn.edu']
        
        lines_test1 = ['Brandon (projects w/ whitespace)',
                    'Courses   	:-		Programming Languages and Techniques,	Biomedical image analysis	,  Pottery',
                     'Projects',
                     '         CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                     'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                     '------------------------------',
                     'lbrandon@wharton.upenn.edu']
        lines_test2 = ['Brandon (projects w/ whitespace)',
                    'Courses:-_##$&^!*()Programming Languages and Techniques, Biomedical image analysis, Software Engineering',
                     'Projects',
                     '         CancerDetector.com, New Jersey, USA - Project manager, codified the assessment and mapped it to the CancerDetector ontology. Member of the UI design team, designed the portfolio builder UI and category search pages UI. Reviewed existing rank order and developed new search rank order approach.',
                     'Biomedical Imaging - Developed a semi-automatic image mosaic program based on SIFT algorithm (using Matlab)',
                     '------------------------------',
                     'lbrandon@wharton.upenn.edu']
        self.assertEqual(get_course(lines),['Programming Languages and Techniques', 'Biomedical image analysis', 'Software Engineering'])
        # test get course function with space
        self.assertEqual(get_course(lines_test1),['Programming Languages and Techniques', 'Biomedical image analysis', 'Pottery'])
        # test get course function with punc
        self.assertEqual(get_course(lines_test2),['Programming Languages and Techniques', 'Biomedical image analysis', 'Software Engineering'])
        
        

      
      
    def test_comma_separated_list(self):
        # test separeted function
        test1 = 'mytest'
        self.assertEqual(comma_separated_list(test1),'m, y, t, e, s, t')
        
    def test_strip_list(self): 
        # test strip function
        test2 = 'thisiscorrect'
        self.assertEqual(strip_list(test2), ['t', 'h', 'i', 's', 'i', 's', 'c', 'o', 'r', 'r', 'e', 'c', 't'])
  
  
if __name__ == '__main__':
    unittest.main()
