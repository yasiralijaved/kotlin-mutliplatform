//
//  ViewController.swift
//  kotlinmultiplatform
//
//  Created by Yasir Ali on 15/06/2019.
//  Copyright © 2019 Yasir Ali. All rights reserved.
//

import UIKit
import KotlinShared

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = CommonKt.createApplicationScreenMessage()
        ApplicationApi().users { (a: String) -> KotlinUnit in
            print(a)
            return .init()
        }
        view.addSubview(label)
    }


}

