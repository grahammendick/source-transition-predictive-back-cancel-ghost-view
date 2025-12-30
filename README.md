# Cancelling predictive back leaves ghost view behind when there's exit or reenter transition
This repository contains an example app that shows a bug when cancelling predictive back on a shared element transition. If there's an exit or reenter transition on the source fragment then the source fragment view isn't removed when the predictive back is cancelled. If you tap the text on the destination fragment then you'll trigger the toast button on the ghost source view that's left behind. The bug only happens if there's an exit of renreenter transition.

## Steps to recreate the problem
1. Press the image to do the shared element transition.
2. Start a predictive back but cancel it.
3. Tap the text at the top of the screen and the toast button on the previous screen triggers.

You can see the bug in the video below. The Layout inspector is on so you can see that the previous view is added when the predictive back starts but isn't removed when it's cancelled.

https://github.com/user-attachments/assets/c3ed21fe-67a5-4e61-bdb2-74ce46ffe740

