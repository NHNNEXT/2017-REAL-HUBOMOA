//
//  ApplyViewController.h
//  REAL-AMIGO
//
//  Created by YongJai on 19/10/2017.
//  Copyright © 2017 YongJai. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Checkbox.h"

@class CalendarViewController;

@interface ApplyViewController : UIViewController  <UIViewControllerTransitioningDelegate, UIViewControllerAnimatedTransitioning, UITextViewDelegate, UITextFieldDelegate>

@property (weak, nonatomic) IBOutlet UILabel *emailLabel;
@property (weak, nonatomic) IBOutlet UITextField *nameTextField;
@property (weak, nonatomic) IBOutlet UITextField *ageTextField;
@property (weak, nonatomic) IBOutlet UITextField *genderTextField;
@property (weak, nonatomic) IBOutlet UILabel *dateLabel;
@property (weak, nonatomic) IBOutlet UITextField *languageTextField;
@property (weak, nonatomic) IBOutlet UITextField *themeTextField;
@property (weak, nonatomic) IBOutlet UITextField *attractionTextField;


@property (weak, nonatomic) IBOutlet UIScrollView *scrollView;
@property (weak, nonatomic) IBOutlet UIButton *submitBtn;

@property NSString *genderString;
@property NSString *data;
@property NSString *date;

@property (weak, nonatomic) IBOutlet UIView *blurView;
@property BOOL isShow;
@property CalendarViewController *calendarViewController;



@end
